package kodlama.io.KodlamaIoDevs.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlama.io.KodlamaIoDevs.business.abstracts.LanguageTechnologyService;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.CreateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.DeleteLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.requests.LanguageTechnology.UpdateLanguageTechnologiesRequest;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetAllLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetByIdLanguageTechnologiesResponse;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;
import kodlama.io.KodlamaIoDevs.core.utilities.results.SuccessDataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.SuccessResult;
import kodlama.io.KodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.KodlamaIoDevs.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlama.io.KodlamaIoDevs.entities.concretes.Language;
import kodlama.io.KodlamaIoDevs.entities.concretes.LanguageTechnology;
import kodlama.io.KodlamaIoDevs.entities.dtos.LanguageWithLanguageTechDto;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {

	private LanguageTechnologyRepository languageTechnologyRepository;
	private LanguageRepository languageRepository;
	private ModelMapper modelMapper;

	@Autowired
	public LanguageTechnologyManager(LanguageTechnologyRepository languageTechnologyRepository,
			LanguageRepository languageRepository, ModelMapper modelMapper) {
		this.languageTechnologyRepository = languageTechnologyRepository;
		this.languageRepository = languageRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAll() {
		List<LanguageTechnology> technologies = languageTechnologyRepository.findAll();
		List<GetAllLanguageTechnologiesResponse> languageTechnologiesResponses = technologies.stream().map(
				languageTechnology -> modelMapper.map(languageTechnology, GetAllLanguageTechnologiesResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllLanguageTechnologiesResponse>>(languageTechnologiesResponses,
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public Result add(CreateLanguageTechnologiesRequest createLanguageTechnologiesRequest) throws Exception {

		LanguageTechnology languageTechnology = modelMapper.map(createLanguageTechnologiesRequest,
				LanguageTechnology.class);

		Language language = languageRepository.findById(createLanguageTechnologiesRequest.getLanguageId()).get();
		languageTechnology.setLanguage(language);

		return new SuccessDataResult<CreateLanguageTechnologiesRequest>(modelMapper
				.map(languageTechnologyRepository.save(languageTechnology), CreateLanguageTechnologiesRequest.class),
				"Yazılım Teknolojisi Eklendi");
	}

	@Override
	public DataResult<UpdateLanguageTechnologiesRequest> update(
			UpdateLanguageTechnologiesRequest updateLanguageTechnologiesRequest) throws Exception {
		LanguageTechnology languageTechnology = modelMapper.map(updateLanguageTechnologiesRequest,
				LanguageTechnology.class);

		Language language = languageRepository.findById(updateLanguageTechnologiesRequest.getLanguageId()).get();
		languageTechnology.setLanguage(language);

		return new SuccessDataResult<UpdateLanguageTechnologiesRequest>(modelMapper
				.map(languageTechnologyRepository.save(languageTechnology), UpdateLanguageTechnologiesRequest.class),
				"Yazılım Alt Teknolojisi Güncellendi");
	}

	@Override
	public Result delete(DeleteLanguageTechnologiesRequest deleteLanguageTechnologiesRequest) {
		languageTechnologyRepository.deleteById(deleteLanguageTechnologiesRequest.getTechnologyId());
		return new SuccessResult("Yazılım Teknolojisi Silindi.");
	}

	@Override
	public DataResult<GetByIdLanguageTechnologiesResponse> getById(int id) {
		Optional<LanguageTechnology> languageTechnology = languageTechnologyRepository.findById(id);
		if (languageTechnology.isPresent()) {
			return new SuccessDataResult<GetByIdLanguageTechnologiesResponse>(
					modelMapper.map(languageTechnology.get(), GetByIdLanguageTechnologiesResponse.class),
					"Yazılım Teknolojisi ID ile Getirildi");
		}
		return null;
	}

	@Override
	public Result deleteAll() {
		languageTechnologyRepository.deleteAll();
		return new SuccessResult("Tüm Yazılım Teknolojileri Silindi.");
	}

	@Override
	public DataResult<LanguageTechnology> getByTechnologyNameAndLanguage(String technologyName, int languageId) {
		return new SuccessDataResult<LanguageTechnology>(
				this.languageTechnologyRepository.getByTechnologyNameAndLanguage_LanguageId(technologyName, languageId),
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public DataResult<List<LanguageTechnology>> getByLanguageIdIn(List<Integer> language) {
		return new SuccessDataResult<List<LanguageTechnology>>(
				this.languageTechnologyRepository.getByLanguage_LanguageIdIn(language),
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public DataResult<List<LanguageTechnology>> getByTechnologyNameContains(String technologyName) {
		return new SuccessDataResult<List<LanguageTechnology>>(
				this.languageTechnologyRepository.getByTechnologyNameContains(technologyName),
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public DataResult<List<LanguageTechnology>> getByTechnologyNameStartsWith(String technologyName) {
		return new SuccessDataResult<List<LanguageTechnology>>(
				this.languageTechnologyRepository.getByTechnologyNameStartsWith(technologyName),
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public DataResult<List<LanguageTechnology>> getByNameAndCategory(
			@RequestParam("technologyName") String technologyName, @RequestParam("languageId") int languageId) {
		return new SuccessDataResult<List<LanguageTechnology>>(
				this.languageTechnologyRepository.getByNameAndCategory(technologyName, languageId),
				"Yazılım Teknolojileri Listelendi.");
	}

	@Override
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<LanguageTechnology> technologies = languageTechnologyRepository.findAll(pageable).getContent();

		List<GetAllLanguageTechnologiesResponse> languageTechnologiesResponses = technologies.stream().map(
				languageTechnology -> modelMapper.map(languageTechnology, GetAllLanguageTechnologiesResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllLanguageTechnologiesResponse>>(languageTechnologiesResponses,
				"Yazılım Teknolojileri Sayfalama İle Listelendi.");

	}

	@Override
	public DataResult<List<GetAllLanguageTechnologiesResponse>> getAllSorted() {

		Sort sort = Sort.by(Sort.Direction.DESC, "technologyName");
		List<LanguageTechnology> technologies = languageTechnologyRepository.findAll(sort);

		List<GetAllLanguageTechnologiesResponse> languageTechnologiesResponses = technologies.stream().map(
				languageTechnology -> modelMapper.map(languageTechnology, GetAllLanguageTechnologiesResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllLanguageTechnologiesResponse>>(languageTechnologiesResponses,
				"Yazılım Teknolojileri Büyükten Küçüğe Listelendi.");
	}

	@Override
	public DataResult<List<LanguageWithLanguageTechDto>> getLanguageTechnologyWithLanguageDetails() {
		return new SuccessDataResult<List<LanguageWithLanguageTechDto>>
		(this.languageTechnologyRepository.getLanguageTechnologyWithLanguageDetails());
	}

	
}
