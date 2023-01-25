package kodlama.io.KodlamaIoDevs.business.requests.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageRequest {

	private String languageName;
	
	private int languageId;
	
}
