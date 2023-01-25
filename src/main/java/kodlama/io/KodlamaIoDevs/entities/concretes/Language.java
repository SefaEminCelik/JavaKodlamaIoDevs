package kodlama.io.KodlamaIoDevs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Sen bir veri tabanı varlığısın veritabanında karşılığın varasdasdasdas
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "technologies" })
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lang_id")
	private int languageId;

	@Column(name = "lang_name")
	private String languageName;

	@OneToMany(mappedBy = "language") //fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LanguageTechnology> technologies;

}
