package Model;

package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.UpdateTimestamp;
import org.w3c.dom.Text;

/**
 * A anota��o @Entity indica que a classe � uma entidade, ou seja,
 * ele ser� utilizada para gerar uma tabela no Banco de Dados.
 * 
 * A anota��o @Table indica o nome da tabela no Banco de dados.
 * Caso ela n�o seja declarada, o Banco criar� a tabela com o mesmo
 * nome da classe.
 */
@Entity
@Table(name = "tb_postagens") 
public class Postagem {

	/**
	 * A anota��o @ID inidica que o atributo � a chave prim�ria da tabela
	 * 
	 * A anota��o @GeneratedValue indica que a chave prim�ria ser� gerada
	 * automaticamente pelo Banco de Dados.
	 * 
	 * O par�metro strategy indica como a Chave Prim�ria ser� gerada. 
	 * 
     * A op��o GenerationType.IDENTITY indica que ser� uma sequ�ncia num�rica iniciando
	 * em 1 e ser� responsabilidade do Banco de dados gerar esta sequ�ncia, ou seja,
	 * a propriedade auto_increment do SQL. 
	 * 
	 * N�o confundir o auto-incremento do Banco de Dados que inicia em 1 com o
	 * indice de um Array (Vetor ou Matriz) que inicia em 0.
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 

	/**
	 * A anota��o @NotNull indica que um atributo n�o pode ser nulo
	 * 
	 * O par�mtero message insere uma mensagem que ser� exibida caso o
	 * atributo seja nulo
	 * 
     * A anota��o @NotBlank indica que um atributo n�o pode ser nulo e 
	 * tamb�m n�o pode ser deixado em branco (vazio).
	 * 
	 * A anota��o @Size tem a fun��o de definir o tamanho minimo e m�ximo de
	 * caracteres de um atributo String. N�o � obrigat�rio definir os 2 par�metros, 
	 * voc� pode definir apenas um deles de acordo com as necessidades do seu
     * projeto.
	 * 
	 *                            ***IMPORTANTE*** 
	 * 
	 * Para utilizar as anota��es acima, n�o esque�a de inserir a Depend�ncia 
	 * Validation na cria��o do projeto ou insira manualmente no arquivo pom.xml
	 * 
	 */
	@NotBlank(message = "O atributo t�tulo � Obrigat�rio e n�o pode utilizar espa�os em branco!") 
	@Size(min = 5, max = 100, message = "O atributo t�tulo deve conter no m�nimo 05 e no m�ximo 100 caracteres")
	private String titulo; 

	@NotNull(message = "O atributo texto � Obrigat�rio!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no m�nimo 10 e no m�ximo 500 caracteres")
	private String texto;

	/**
	 * A anota��o @UpdateTimestamp Indica se o atributo receber� um Timestamp (Data e hora do sistema)
	 * e sempre que a Postagem for atualizada o atributo tamb�m ser� atualizado.
	 */
	@UpdateTimestamp
	private LocalDateTime data;

	/**
	 *  Anota��o @ManyToOne: Anota��o que indica que a Classe Postagem ter� um relacionamento
	 *  do tipo Many To One (Muitos para Um) com a Classe Tema
	 *  
	 *  Anota��o @JsonIgnoreProperties("postagem"): Anota��o que desabilita a recursividade
	 *  infinita durante a exibi��o dos dados no formato JSON (Desserializa��o).
	 *  
	 *  private Tema tema;: Objeto do tipo Tema que atuar� como a "chave estrangeira" da Classe
	 *  Postagem na rela��o com a Classe Tema, al�m de exibir o tema da postagem
	 * 
	 *  N�o esque�a de criar os m�todos getters e setters para o atributo tema.
	 */

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	/**
	 * 
	 * Os M�todos Get e Set obrigatoriamente devem ser criados para todos os atributos
     * da Classe, inclusive os novos atributos que forem adicionados no decorrer do
     * processo de Desenvolvimento.
	 * 
	 */	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * M�todos Get e Set para o atributo tema
	 */
	public Text getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}