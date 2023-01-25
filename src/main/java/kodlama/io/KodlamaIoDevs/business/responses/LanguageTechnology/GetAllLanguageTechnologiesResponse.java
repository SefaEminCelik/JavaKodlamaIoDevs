package kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology;

import kodlama.io.KodlamaIoDevs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageTechnologiesResponse {

	private int technologyId;
	private String technologyName;
	
	private Language language;
	
	
	
	
}
