package hibernate;

import java.util.List;
import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.domain.Student;

public class StudentDAOImpl implements IStudentDAO {
//		JdbcTemplate.update("insert into t_student (name,age) values (?,?)", stu.getName(),stu.getAge());

	public void save(Student stu) {
		HibernateMock.save(stu);
	}

	public void delete(Long id) {
	}

	public void update(Long id, Student stu) {
	}

	public Student get(Long id) {
		return null;
	}

	public List<Student> listall() {
		return null;
	}
}
