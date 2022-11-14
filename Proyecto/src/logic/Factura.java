package logic;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "factura")
@XmlType(propOrder = {"nomEmp", "direcEmp", "telEmp", "cedJur", "fecha", "numFactElec", "nomClie", "cedClie", "codCaja", "nomCaja", "lp", "subTotal", "descuento", "IVA", "total"})
public class Factura implements Serializable {

    public Factura(String nomEmp, String DirecEmp, int TelEmp, int CedJur, String Fecha, int numFactElec, String nomClie, String cedClie, int codCaja, String nomCaja,
            double subTotal, double descuento, double IVA, double total) {

        this.nomEmp = nomEmp;
        this.DirecEmp = DirecEmp;
        this.TelEmp = TelEmp;
        this.CedJur = CedJur;
        this.Fecha = Fecha;
        this.numFactElec = numFactElec;
        this.nomClie = nomClie;
        this.cedClie = cedClie;
        this.codCaja = codCaja;
        this.nomCaja = nomCaja;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.IVA = IVA;
        this.total = total;
    }

    public Factura() {
        this.nomEmp = "-";
        this.DirecEmp = "-";
        this.TelEmp = 0;
        this.CedJur = 0;
        this.Fecha = "-";
        this.numFactElec = 0;
        this.nomClie = "-";
        this.cedClie = "-";
        this.codCaja = 0;
        this.nomCaja = "-";
        this.subTotal = 0;
        this.descuento = 0;
        this.IVA = 0;
        this.total = 0;
    }

    @XmlElement
    public String getNomEmp() {
        return nomEmp;
    }

    @XmlElement
    public String getDirecEmp() {
        return DirecEmp;
    }

    @XmlElement
    public int getTelEmp() {
        return TelEmp;
    }

    @XmlElement
    public int getCedJur() {
        return CedJur;
    }

    @XmlElement
    public String getFecha() {
        return Fecha;
    }

    @XmlElement
    public int getNumFactElec() {
        return numFactElec;
    }

    @XmlElement
    public String getNomClie() {
        return nomClie;
    }

    @XmlElement
    public String getCedClie() {
        return cedClie;
    }

    @XmlElement
    public int getCodCaja() {
        return codCaja;
    }

    @XmlElement
    public String getNomCaja() {
        return nomCaja;
    }

    @XmlElement
    public double getSubTotal() {
        return subTotal;
    }

    @XmlElement
    public double getDescuento() {
        return descuento;
    }

    @XmlElement
    public double getIVA() {
        return IVA;
    }

    @XmlElement
    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append(getNomEmp());
        r.append("\n");
        r.append(getDirecEmp());
        r.append("\n");
        r.append(getTelEmp());
        r.append("\n");
        r.append(getCedJur());
        r.append("\n");
        r.append(getFecha());
        r.append("\n");
        r.append(getNumFactElec());
        r.append("\n");
        r.append(getNomClie());
        r.append("\n");
        r.append(getCedClie());
        r.append("\n");
        r.append(getCodCaja());
        r.append("\n");
        r.append(getNomCaja());
        r.append("\n");
        r.append(getSubTotal());
        r.append("\n");
        r.append(getDescuento());
        r.append("\n");
        r.append(getIVA());
        r.append("\n");
        r.append(getTotal());
        r.append("\n");

        return r.toString();
    }

    private final String nomEmp;
    private final String DirecEmp;
    private final int TelEmp;
    private final int CedJur;
    private final String Fecha;
    private final int numFactElec;
    private final String nomClie;
    private final String cedClie;
    private final int codCaja;
    private final String nomCaja;
    private final double subTotal;
    private final double descuento;
    private final double IVA;
    private final double total;
}
