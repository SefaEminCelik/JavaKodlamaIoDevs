package kodlama.io.KodlamaIoDevs.business.responses.Language;

import java.util.List;

import kodlama.io.KodlamaIoDevs.business.responses.LanguageTechnology.GetAllLanguageTechnologiesResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {

	private int languageId;
	private String languageName;
	
	
	private List<GetAllLanguageTechnologiesResponse> technologies;
}
