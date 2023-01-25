package kodlama.io.KodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.KodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.CreateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.DeleteLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.UpdateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetAllLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetByIdLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;
import kodlama.io.KodlamaIoDevs.entities.concretes.LanguageTechnology;
import kodlama.io.KodlamaIoDevs.entities.dtos.LanguageWithLanguageTechDto;

@RestController
@RequestMapping("/api/tecnologies")
@CrossOrigin
public class LanguageTechnologyController {

	private LanguageTechnologyService technologyService;

	@Autowired
	public LanguageTechnologyController(LanguageTechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAll() {
		return technologyService.getAll();
	}

	@PostMapping("/add")
	public Result add(CreateLanguageTechnologiesRequest createLanguageRequest) throws Exception {
		return this.technologyService.add(createLanguageRequest);
	}

	@PutMapping("/update")
	public Result update(UpdateLanguageTechnologiesRequest languageTechnologiesRequest) throws Exception {
		return technologyService.update(languageTechnologiesRequest);
	}

	@DeleteMapping("/deletebyid")
	public Result deleteById(DeleteLanguageTechnologiesRequest deleteLanguageTechnologiesRequest) {
		return this.technologyService.delete(deleteLanguageTechnologiesRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<GetByIdLanguageTechnologiesResponse> getById(int id) {
		return this.technologyService.getById(id);
	}

	@DeleteMapping("/deleteall")
	public Result deleteAll() {
		return this.technologyService.deleteAll();

	}
	@GetMapping("/getByTechnologyNameAndLanguage")
	public DataResult<LanguageTechnology> getByTechnologyNameAndLanguage(String technologyName, int languageId){
		return this.technologyService.getByTechnologyNameAndLanguage(technologyName, languageId);
	}
	
	@PostMapping("/getByLanguageIn")
	public DataResult<List<LanguageTechnology>> getByLanguageIn(@RequestBody List<Integer> language){
		return this.technologyService.getByLanguageIdIn(language);
	}
	
	@GetMapping("/getByTechnologyNameContains")
	public DataResult<List<LanguageTechnology>> getByTechnologyNameContains(String technologyName){
		return this.technologyService.getByTechnologyNameContains(technologyName);
	}
	
	@GetMapping("/getByTechnologyNameStartsWith")
	public DataResult<List<LanguageTechnology>> getByTechnologyNameStartsWith(String technologyName){
		return this.technologyService.getByTechnologyNameStartsWith(technologyName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAll(int pageNo, int pageSize){
		return this.technologyService.getAll(pageNo, pageSize);
		
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAllSorted(){
		return this.technologyService.getAllSorted();
	}
	@GetMapping("/getLanguageTechWithLanguageDetails")
	public DataResult<List<LanguageWithLanguageTechDto>> getLanguageTechnologyWithLanguageDetails() {
		return this.technologyService.getLanguageTechnologyWithLanguageDetails();
	}
	
	
}
