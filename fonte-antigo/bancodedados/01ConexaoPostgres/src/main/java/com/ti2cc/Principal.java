package com.ti2cc;
import java.util.*;

public class Principal {
	
	public static void main(String[] args) {
		
		int x = 0;
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		DAO dao = new DAO();
		
		dao.conectar();

		switch(x) {
		case 1:
			//Inserir um elemento na tabela
			Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
			if(dao.inserirUsuario(usuario) == true) {
				System.out.println("Inserção com sucesso -> " + usuario.toString());
			}
			//Mostrar usuários do sexo masculino		
			System.out.println("==== Mostrar usuários do sexo masculino === ");
			Usuario[] usuarios = dao.getUsuariosMasculinos();
			for(int i = 0; i < usuarios.length; i++) {
				System.out.println(usuarios[i].toString());
			}
			break;
		case 2:
			//Atualizar usuário
			usuario.setSenha("nova senha");
			dao.atualizarUsuario(usuario);
			
			//Mostrar usuários do sexo masculino
			System.out.println("==== Mostrar usuários === ");
			usuarios = dao.getUsuarios();
			for(int i = 0; i < usuarios.length; i++) {
				System.out.println(usuarios[i].toString());
			}
			break;
		case 3:
			//Excluir usuário
			dao.excluirUsuario(usuario.getCodigo());
			
			//Mostrar usuários
			usuarios = dao.getUsuarios();
			System.out.println("==== Mostrar usuários === ");		
			for(int i = 0; i < usuarios.length; i++) {
				System.out.println(usuarios[i].toString());
			}	
			break;
			default:
				break;
		}
		

		
		
		dao.close();
	}
}