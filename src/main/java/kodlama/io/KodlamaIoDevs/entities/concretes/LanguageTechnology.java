package kodlama.io.KodlamaIoDevs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "languagesTechnology")
public class LanguageTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tech_id")
	private int technologyId;

	@Column(name = "tech_name")
	private String technologyName;

	@ManyToOne() //fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "lang_id")
	private Language language;

}
