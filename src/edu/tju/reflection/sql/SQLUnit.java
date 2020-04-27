package edu.tju.reflection.sql;

import java.lang.reflect.Field;
import java.util.List;
import edu.tju.reflection.annotation.*;

public class SQLUnit {
	
	/**
	 * @param entity
	 * @return 返回表的名字
	 * @throws Exception
	 */
	public String getTableName(SQLable entity) throws Exception {
		Class<? extends SQLable> clazz = entity.getClass();
		if (!clazz.isAnnotationPresent(Table.class)) {
			throw new Exception("Miss table name");
		}
		String tableName = clazz.getAnnotation(Table.class).value();
		return tableName;
	}
	
	public String getColumnName(SQLable entity, Field field) throws Exception {
		String fieldName = field.getAnnotation(Column.class).value();
		return fieldName;
	}
	
	public String getFieldValue(SQLable entity, Field field) throws Exception {
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		Object value = field.get(entity);
		field.setAccessible(accessible);
		String fieldName;
		
		if (value == null) {
			fieldName = "";
		} else {
			if (value instanceof String) {
				fieldName = "'" +  value + "'";
			} else {
				fieldName = value.toString();
			}
		}
		return fieldName;
	}
	
	/**
	 * @param entity
	 * @return 返回包含所有主键的WHERE语句
	 * @throws Exception
	 */
	public String getSQLByPK(SQLable entity) throws Exception {
		Class<? extends SQLable> clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String sql = null;
		for (Field field : fields) {
			if (field.getAnnotation(PrimaryKey.class) != null) {
				if (!field.isAnnotationPresent(Column.class)) {
					throw new Exception("miss column name of primary key");
				}
				String unit = getNameValueUnit(entity, field);
				if (unit.length() == 0) {
					throw new Exception("the value of primary key can't be null");
				}
				if (sql == null) {
					sql = unit;
				} else {
					sql += " AND " + unit;
				}
			}
		}
		if (sql == null) {
			throw new Exception("there is no primary key");
		}
		return sql;
	}
	
	public String getSQLByNPK(SQLable entity) throws Exception {
		Class<? extends SQLable> clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String sql = null;
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				String unit = getNameValueUnit(entity, field);
				if (sql == null) {
					sql = unit;
				} else {
					sql += " AND " + unit;
				}
			}
			
		}
		if (sql == null) {
			throw new Exception("there is no other attribute");
		}
		return sql;
	}
	
	/**
	 * @param entity
	 * @return 返回该属性对应的条件
	 * @throws Exception
	 */
	private String getNameValueUnit(SQLable entity, Field field) throws Exception {
		String name = getColumnName(entity, field);
		String value = getFieldValue(entity, field);
		return name + " = " + value;
	}
	
	
	/**
	 * 根据传入的参数返回查询语句
	 * 只支持根据主键查询
	 * 
	 * @param user
	 * @return 返回查询语句
	 */
	public String query(SQLable entity) throws Exception {
		String table = getTableName(entity);
		String sql = "SELECT * FROM " + table + " WHERE " + getSQLByPK(entity) + ";";
		return sql;
	}

	/**
	 * 根据传入的参数返回插入语句
	 * 
	 * @param user
	 * @return 返回插入语句
	 * @throws Exception 
	 */
	public String insert(SQLable entity) throws Exception {
		String sql = "INSERT INTO " + getTableName(entity) + " " 
				+ getInsertName(entity) + " VALUES " + getInsertValue(entity) + ";";
		return sql;
	}
	
	private String getInsertValue(SQLable entity) throws Exception {
		String sql = null;
		Class<? extends SQLable> clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields) {
			if (field.isAnnotationPresent(Column.class)) {
				String value = getFieldValue(entity, field);
				if (sql == null) {
					sql = value;
				} else {
					sql += ", " + value;
				}
			}
		}
		if (sql == null) {
			throw new Exception("there is no attribute");
		}
		return "(" + sql + ")";
	}
	
	private String getInsertName(SQLable entity) throws Exception {
		String sql = null;
		Class<? extends SQLable> clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field: fields) {
			if (field.isAnnotationPresent(Column.class)) {
				String name = getColumnName(entity, field);
				if (sql == null) {
					sql = name;
				} else {
					sql += ", " + name;
				}
			}
		}
		if (sql == null) {
			throw new Exception("there is no attribute");
		}
		return "(" + sql + ")";
	}

	/**
	 * 根据传入的参数返回插入语句
	 * 
	 * @param users
	 * @return 返回插入语句
	 * @throws Exception 
	 */
	public String insert(List<SQLable> entity) throws Exception {
		if (entity.size() == 0) {
			throw new Exception("there is no entity");
		}
		String sql = "INSERT INTO " + getTableName(entity.get(0)) + " " 
				+ getInsertName(entity.get(0)) + " VALUES " + getInsertValue(entity.get(0));
		for (int i = 1; i < entity.size(); i++) {
			sql += ", " + getInsertValue(entity.get(i));
		}
		return sql + ";";
	}

	/**
	 * 根据传入的参数返回删除语句（删除id为user.id的记录）
	 * 
	 * @param user
	 * @return 返回删除语句
	 * @throws Exception 
	 */
	public String delete(SQLable entity) throws Exception {
		String table = getTableName(entity);
		String sql = "DELETE * FROM " + table + " WHERE " + getSQLByPK(entity) + ";";
		return sql;
	}

	/**
	 * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
	 * 
	 * @param user
	 * @return 返回更新语句
	 * @throws Exception 
	 */
	public String update(SQLable entity) throws Exception {
		String sql = "UPDATE " + getTableName(entity) 
				+ " SET " + getSQLByNPK(entity) + 
				" WHERE " + getSQLByPK(entity) + ";";
		return sql;
	}

}
