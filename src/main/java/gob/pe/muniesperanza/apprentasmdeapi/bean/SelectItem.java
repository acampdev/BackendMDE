package gob.pe.muniesperanza.apprentasmdeapi.bean;

import java.io.Serializable;

public class SelectItem implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer value;
  private String label;

  public SelectItem() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}

