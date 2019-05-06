package dz.unvbechar.server.lamiri_service.controllers;

import dz.unvbechar.server.lamiri_service.LamiriServiceApplication;
import dz.unvbechar.server.lamiri_service.dao.RepositoryDao;
import dz.unvbechar.server.lamiri_service.entity.FichPersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service // This means that this class is a Controller
@RequestMapping(path = "/fich_person")
public class FichPersonneController {

	@Autowired
	public RepositoryDao rdao;

	@PersistenceContext
	EntityManager em;

	@RequestMapping(path = "add")
	public @ResponseBody FichPersonne addnewPesonne(@RequestParam("famely") String first_name,
			@RequestParam("name") String last_name, @RequestParam("date") String date_of_birth,
			@RequestParam("age") String age, @RequestParam("Sexy") char sexe, @RequestParam("tag") String privacy_tag) {
		FichPersonne f = new FichPersonne();
		f.setFirst_name(first_name);
		f.setLast_name(last_name);
		f.setSexe(sexe);
		f.setAge(age);
		// f.setId(12);
		f.setDate_of_birth(date_of_birth);

		LamiriServiceApplication.Fich.save(f);

		return f;
	}

	@RequestMapping(path = "update", method = RequestMethod.POST)
	public FichPersonne update(@RequestBody FichPersonne f) {

		LamiriServiceApplication.Fich.update(f);

		return f;
	}

	@GetMapping(path = "all")
	public @ResponseBody List<FichPersonne> alllistview() {

		FichPersonne f = null;
		System.out.println("------------------------------------ view all list from ficheperson ---------------------");
		return LamiriServiceApplication.Fich.findAll(f);
	}

	@GetMapping(path = "one")
	public @ResponseBody Object oneview(@RequestParam("id") String id) {
		FichPersonne f = LamiriServiceApplication.Fich.findOne(id);

		if (f == null) {
			System.out.println(" not fond ");
			return new String("not fond");
		} else {
			System.out.println("fond ");
			return f;

		}

	}

	@GetMapping(path = "searche")
	public @ResponseBody Object oneview(@Param("id") String id, @Param("date") String date,
			@Param("fname") String fname, @Param("lname") String lname) {

		FichPersonne f = LamiriServiceApplication.Fich.findOne(id);

		return f;

	}

	@GetMapping(path = "delete")
	public @ResponseBody String delete(@Param("id") String id) {

		LamiriServiceApplication.Fich.delete(id);
		return "<h1>deleted</h1>";
	}

}
