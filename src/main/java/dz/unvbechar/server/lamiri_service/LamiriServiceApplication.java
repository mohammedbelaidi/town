package dz.unvbechar.server.lamiri_service;

import dz.unvbechar.server.lamiri_service.dao.RepositoryDao;
import dz.unvbechar.server.lamiri_service.entity.FichPersonne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class LamiriServiceApplication {

	public static RepositoryDao<FichPersonne> Fich;
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LamiriServiceApplication.class, args);
		Fich = ctx.getBean(RepositoryDao.class);
//		FichPersonne f = new FichPersonne();
//		f.setFirst_name("belaidi");
//		f.setLast_name("mohammed");
//		f.setSexe('h');
//		f.setAge(20);
//		//f.setId(12);
//		f.setDate_of_birth("01/01/1999");
//
//
//		Fich.save(f);
	}

}
