package kodlama.io.KodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.CreateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.DeleteLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.UpdateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetAllLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetByIdLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;
import kodlama.io.KodlamaIoDevs.entities.concretes.LanguageTechnology;
import kodlama.io.KodlamaIoDevs.entities.dtos.LanguageWithLanguageTechDto;

public interface LanguageTechnologyService {
	
	DataResult<List<GetAllLanguageTechnologiesResponse>> getAll();
	
	Result add(CreateLanguageTechnologiesRequest createLanguageTechnologiesRequest) throws Exception;
	
	Result update(UpdateLanguageTechnologiesRequest updateLanguageTechnologiesRequest) throws Exception;
	
	Result delete(DeleteLanguageTechnologiesRequest deleteLanguageTechnologiesRequest);
	
	DataResult<GetByIdLanguageTechnologiesResponse> getById(int technologyId);
	
	Result deleteAll();
	
	
	//TAMAM
	DataResult<List<GetAllLanguageTechnologiesResponse>> getAll(int pageNo, int pageSize);
	//TAMAM
	DataResult<List<GetAllLanguageTechnologiesResponse>> getAllSorted();
	//RESPONSE-----MAP
	DataResult<LanguageTechnology> getByTechnologyNameAndLanguage(String technologyName, int languageId);
	//RESPONSE----MAP
	DataResult<List<LanguageTechnology>> getByLanguageIdIn(List<Integer> language);
	//RESPONSE----MAP
	DataResult<List<LanguageTechnology>> getByTechnologyNameContains(String technologyName);
	//RESPONSE----MAP
	DataResult<List<LanguageTechnology>> getByTechnologyNameStartsWith(String technologyName);
	
	//RESPONSE-----MAP
	DataResult<List<LanguageTechnology>> getByNameAndCategory(String technologyName, int languageId);
	
	DataResult<List<LanguageWithLanguageTechDto>> getLanguageTechnologyWithLanguageDetails();
	
	
	
}
