package com.example.demo.Model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProduitId implements Serializable {

  private static final long serialVersionUID = 1397991612680642405L;
  @Column(name = "\"ref_piece\"", nullable = false)
  private Long refPiece;

  public Long getRefPiece() {
    return refPiece;
  }

  public void setRefPiece(Long refPiece) {
    this.refPiece = refPiece;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProduitId entity = (ProduitId) o;
    return Objects.equals(this.refPiece, entity.refPiece);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refPiece);
  }

}
