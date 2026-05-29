package ni.edu.uam.Facturacion.modelo;

import java.math.BigDecimal;
import javax.persistence.*;

import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @Column(length=9)
    private int id;

    @Column(length=50)
    @Required
    private String descripcion;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = true
    )
    @DescriptionsList
    private Categoria categoria;

    @Money
    private BigDecimal precio;

    @Files
    @Column(length=32)
    private String fotos;

    @TextArea
    private String observaciones;
}
