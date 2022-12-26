
import Usuario.Cliente;
import Usuario.Usuario;
import Venda.Venda;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Willian Murayama
 */
public class MainTest {

    public static void main(String[] args) {
        Controller.ControladorSerializable.ativarRegistro();
        ArrayList<Venda> venda = new ArrayList<Venda>();
        venda.add(new Venda("Teste"));
//        Controller.ControladorSerializable.salvarVendas(venda);
        venda = Controller.ControladorSerializable.carregarVendas();
        System.out.println(venda.get(0).getVenda());
        Usuario Usuario = new Cliente(0, "nometeste", "cpfteste", "rgteste", LocalDate.now(), "endereco teste", "cep teste", "emal teste", LocalDate.now());

        System.out.println(Usuario.toString());
    }
}
