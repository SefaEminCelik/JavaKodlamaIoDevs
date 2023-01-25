package kodlama.io.KodlamaIoDevs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.KodlamaIoDevs.business.abstracts.LanguageService;
import kodlama.io.KodlamaIoDevs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetByIdLanguageResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/languages")
public class LangageController {

	private LanguageService languageService;

	public LangageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllLanguagesResponse>> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		return this.languageService.add(createLanguageRequest);
	}

	@PutMapping("/update")
	public Result update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		return languageService.update(updateLanguageRequest);
	}

	@DeleteMapping("/deletebyid")
	public Result deleteById(DeleteLanguageRequest deleteLanguageRequest) {
		return this.languageService.delete(deleteLanguageRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<GetByIdLanguageResponse> getById(int languageId) {
		return languageService.getById(languageId);
	}

	@DeleteMapping("/deleteall")
	public Result deleteAll() {
		return languageService.deleteAll();
	}
}
