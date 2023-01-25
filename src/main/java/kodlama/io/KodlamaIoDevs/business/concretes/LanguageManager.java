package kodlama.io.KodlamaIoDevs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.KodlamaIoDevs.business.abstracts.LanguageService;
import kodlama.io.KodlamaIoDevs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.DeleteLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.Language.GetByIdLanguageResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;
import kodlama.io.KodlamaIoDevs.core.utilities.results.SuccessDataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.SuccessResult;
import kodlama.io.KodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.KodlamaIoDevs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	private ModelMapper modelMapper;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository, ModelMapper modelMapper) {
		super();
		this.languageRepository = languageRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<GetAllLanguagesResponse>> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = languages.stream()
				.map(language -> modelMapper.map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllLanguagesResponse>>(languagesResponse, "Yazılım Dilleri Listelendi");
	}

	@Override
	public DataResult<CreateLanguageRequest> add(CreateLanguageRequest createLanguageRequest) throws Exception {
		Language language = modelMapper.map(createLanguageRequest, Language.class);
		if (language.getLanguageName().isEmpty()) {
			throw new Exception("Programlama Dili Boş olamaz");
		}
		return new SuccessDataResult<CreateLanguageRequest>(
				modelMapper.map(languageRepository.save(language), CreateLanguageRequest.class),
				"Yazılım Dili Eklendi");
	}

	@Override
	public DataResult<UpdateLanguageRequest> update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		Language language = modelMapper.map(updateLanguageRequest, Language.class);
		return new SuccessDataResult<UpdateLanguageRequest>(
				modelMapper.map(languageRepository.save(language), UpdateLanguageRequest.class),
				"Yazılım Dili Güncellendi");
	}

	@Override
	public Result delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageRepository.deleteById(deleteLanguageRequest.getLanguageId());
		return new SuccessResult("Yazılım Dili Silindi");
	}

	@Override
	public DataResult<GetByIdLanguageResponse> getById(int id) {
		Optional<Language> languages = languageRepository.findById(id);
		if (languages.isPresent()) {
			return new SuccessDataResult<GetByIdLanguageResponse>(
					modelMapper.map(languages.get(), GetByIdLanguageResponse.class), "Yazılım Dili ID ile Getirildi");
		}
		return null;
	}

	@Override
	public Result deleteAll() {
		languageRepository.deleteAll();
		return new SuccessResult("Tüm Yazılım Dilleri Silindi");
	}

}
