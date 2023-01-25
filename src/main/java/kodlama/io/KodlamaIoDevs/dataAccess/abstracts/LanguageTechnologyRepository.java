package kodlama.io.KodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.KodlamaIoDevs.entities.concretes.LanguageTechnology;
import kodlama.io.KodlamaIoDevs.entities.dtos.LanguageWithLanguageTechDto;

public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology,Integer>{

	
	LanguageTechnology getByTechnologyNameAndLanguage_LanguageId(String technologyName, int languageId);
	
	
	List<LanguageTechnology> getByLanguage_LanguageIdIn(List<Integer> language);
	
	List<LanguageTechnology> getByTechnologyNameContains(String technologyName);
	
	List<LanguageTechnology> getByTechnologyNameStartsWith(String technologyName);
	
	
	@Query("From LanguageTechnology where technologyName=:technologyName and language.languageId=:languageId")
	List<LanguageTechnology> getByNameAndCategory(String technologyName, int languageId);
	
	@Query("Select new kodlama.io.KodlamaIoDevs.entities.dtos.LanguageWithLanguageTechDto"
			+ "(t.technologyId, t.technologyName, l.languageName) "
			+ "From Language l Inner Join l.technologies t")
	List<LanguageWithLanguageTechDto> getLanguageTechnologyWithLanguageDetails();
	
	
	
	
}
