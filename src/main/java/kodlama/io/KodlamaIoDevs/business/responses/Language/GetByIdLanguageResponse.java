package kodlama.io.KodlamaIoDevs.business.responses.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdLanguageResponse {
	
	private int languageId;
	private String languageName;
	
}
