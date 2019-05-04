package pe.com.model.repository;

import java.util.List;

public interface JpaRepository<T> {

	Integer Insert(T t)throws Exception;
	Integer Update(T t)throws Exception;
	Integer Delete(T t)throws Exception;
	List<T> FindAll() throws Exception;
	T FindById(T t) throws Exception;
	
}
