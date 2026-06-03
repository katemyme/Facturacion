package ni.edu.uam.Facturacion.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class Detalle {

    private int cantidad;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = true
    )
    private Producto producto;
}