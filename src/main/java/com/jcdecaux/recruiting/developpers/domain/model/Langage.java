package com.jcdecaux.recruiting.developpers.domain.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Langage
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-27T21:07:20.470+01:00")

@Entity
@Table(name = "LANGAGE")
public class Langage {
	
  @JsonProperty("id")
  @Id
  @Column(name = "id")
  private Long id;

  @JsonProperty("name")
  @Column(name = "name")
  private String name = null;
  
  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="lang_dev",joinColumns=@JoinColumn(name="langage_id"),inverseJoinColumns=@JoinColumn(name="dev_id"))
  private Set<Developpeur> developpeurs;

  public Set<Developpeur> getDeveloppeurs() {
	return developpeurs;
  }


/**
   * Langage Status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    APPROVE("approve");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusEnum status = null;

  @JsonProperty("complete")
  @Transient
  private Boolean complete = false;

  public Langage id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Langage name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Langage status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Langage Status
   * @return status
  **/
  @ApiModelProperty(value = "Langage Status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Langage complete(Boolean complete) {
    this.complete = complete;
    return this;
  }

   /**
   * Get complete
   * @return complete
  **/
  @ApiModelProperty(value = "")


  public Boolean getComplete() {
    return complete;
  }

  public void setComplete(Boolean complete) {
    this.complete = complete;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Langage langage = (Langage) o;
    return Objects.equals(this.id, langage.id) &&
        Objects.equals(this.name, langage.name) &&
        Objects.equals(this.status, langage.status) &&
        Objects.equals(this.complete, langage.complete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, complete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Langage {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

