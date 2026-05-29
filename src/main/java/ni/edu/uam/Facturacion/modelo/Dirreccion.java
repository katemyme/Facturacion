package ni.edu.uam.Facturacion.modelo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
@Getter @Setter
public class Dirreccion {

    @Column(length = 30)
    String ViaPublica;
    @Column(length = 5)
    int CodigoPostal;
    @Column(length =  20)
    String municipio;
    @Column(length = 30)
    String provincia;


}
