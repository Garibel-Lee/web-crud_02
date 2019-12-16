package hibernate;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import com._520it.smis.domain.Student;
import com._520it.smis.until.JdbcTemplate;

//模拟hibernate，脚踏实地
public class HibernateMock {
	// 模拟保存操作"insert into t_student (name,age) values "
	public static void save(Object obj) {

		try {
			String tableName = obj.getClass().getSimpleName();
			Table table = obj.getClass().getAnnotation(Table.class);
			if (tableName != null) {
				tableName = table.value();
			}
			StringBuilder sql = new StringBuilder(80);
			sql.append("insert into ").append(tableName).append(" (");
			// 拼需要插入哪一些列的sql name age
			StringBuilder clolumnsql = new StringBuilder(80);
			// 拼需要插入哪些参数的sql ？，？
			StringBuilder placeHolderSql = new StringBuilder(80);
			List<Object>  params=new ArrayList<>();			
			
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				// 对象中的属性
				String propertyName = pd.getName();
				// 过滤ID
				//未来：判断主键标签 为NULL
			
				if (!"id".equals(propertyName)) {
					clolumnsql.append(propertyName).append(",");					
					// 获取属性的值，调用属性的getter方法
					Object val = pd.getReadMethod().invoke(obj);
					placeHolderSql.append("?").append(",");
					params.add(val);
				}
			}
			// 删除最后一个逗号
			clolumnsql.deleteCharAt(clolumnsql.length() - 1);
			placeHolderSql.deleteCharAt(placeHolderSql.length() - 1);
			sql.append(clolumnsql);
			sql.append(") values (");
			sql.append(placeHolderSql);
			sql.append(")");
			
			
			System.out.println("SQL: "+sql);
			System.out.println("PARAMS: "+params);
			
			JdbcTemplate.update	(sql.toString(),params.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Student stu = new Student("三SS小",12);
		HibernateMock.save(stu);
	}

}
