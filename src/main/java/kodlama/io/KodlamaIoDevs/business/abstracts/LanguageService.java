package kodlama.io.KodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlama.io.KodlamaIoDevs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetByIdLanguageResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;

public interface LanguageService {
	
	
	DataResult<List<GetAllLanguagesResponse>> getAll();
	
	Result add (CreateLanguageRequest createLanguageRequest) throws Exception;
	
	Result update (UpdateLanguageRequest updateLanguageRequest) throws Exception;
	
	Result delete (DeleteLanguageRequest deleteLanguageRequest);
	
	DataResult<GetByIdLanguageResponse> getById(int languageId);
	
	Result deleteAll();
	
 
}
