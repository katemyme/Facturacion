package ni.edu.uam.Facturacion.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@View(
        name = "Simple",
        members = "numero, nombre"
)
@Getter @Setter
public class Cliente {

    @Id
    @Column(length=6)
    private int numero;

    @Column(length=50)
    @Required
    private String nombre;

    @Embedded
    @NoFrame
    private Direccion direccion;
}

