package br.org.serratec.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.org.serratec.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> findByEmail(String email);
	public Optional<Cliente> findByNome(String nome);
	public Optional<Cliente> findByCpf(String cpf);
	public Cliente findByUsuario(String username);
	
	public Cliente existsByNome(String nome);
	public Cliente existsByCpf(String cpf);
	public Cliente deleteByNome(String nome);
	public Cliente deleteByCpf(String cpf);
	public Cliente getByCpf(String cpf);
	
	
}
