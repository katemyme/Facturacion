package ni.edu.uam.Facturacion.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

import ni.edu.uam.Facturacion.calculadores.CalculadorSiguienteNumeroParaAnyo;

@Entity
@Getter @Setter
public class Factura {

    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length=6)
    @DefaultValueCalculator(
            value = CalculadorSiguienteNumeroParaAnyo.class,
            properties = @PropertyValue(
                    name = "anyo"
            )
    )
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private Cliente cliente;

    @ElementCollection
    @ListProperties(
            "producto.id, producto.descripcion, cantidad"

    )
    private Collection<Detalle> detalles;
}