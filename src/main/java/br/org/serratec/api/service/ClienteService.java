package br.org.serratec.api.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.org.serratec.api.dto.ClienteInserirDTO;
import br.org.serratec.api.config.MailConfig;
import br.org.serratec.api.dto.ClienteDTO;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.Endereco;
import br.org.serratec.api.repository.ClienteRepository;
import br.org.serratec.api.dto.EnderecoDTO;
import br.org.serratec.api.exception.CpfException;
import br.org.serratec.api.exception.EmailException;
import br.org.serratec.api.exception.UsernameException;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder cripto;
	
	
	@Autowired
	private MailConfig mailConfig;
	
	
	public List<ClienteDTO> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for(Cliente cliente: clientes) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente);
            clientesDTO.add(clienteDTO);
        }
        //return pedidoDTO;
        return clientes.stream().map(p-> new ClienteDTO(p)).collect(Collectors.toList());
    }
	//RETIREI O OPTIONAL DO CLIENTE DTO, PERGUUNTAR SE É CORRETO
	public ClienteDTO buscarId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		ClienteDTO clienteDTO = new ClienteDTO(cliente.get());
		if(cliente.isPresent()) {
			return clienteDTO;
		}else {
			return null;
		}	
	}
	//RETIREI O OPTIONAL DO CLIENTE DTO, PERGUUNTAR SE É CORRETO
	public ClienteDTO buscarCpf(String cpf) {
		Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
		ClienteDTO clienteDTO =new ClienteDTO(cliente.get());
		if(cliente.isPresent()) {
			return clienteDTO;
		}else {
			return null;
		}
	}
	//RETIREI O OPTIONAL DO CLIENTE DTO, PERGUUNTAR SE É CORRETO
	public ClienteDTO buscarEmail(String email) {
		Optional<Cliente> cliente = clienteRepository.findByEmail(email);
		ClienteDTO clienteDTO = new ClienteDTO(cliente.get());
		if(cliente.isPresent()) {
			return clienteDTO;
		}else {
			return null;
		}
	}
	public ClienteDTO inserir(ClienteInserirDTO clienteInserirDto) 	throws EmailException, CpfException, UsernameException, IOException {
		
		if (clienteRepository.findByEmail(clienteInserirDto.getEmail()) != null) {
			throw new EmailException("Email já cadastrado! Escolha outro.");
		} else if (clienteRepository.findByCpf(clienteInserirDto.getCpf()) != null) {
			throw new CpfException("Este CPF já se encontra cadastrado!");
		} else if (clienteRepository.findByUsuario(clienteInserirDto.getUsuario()) != null) {
			throw new UsernameException("O username informado já está em uso! Escolha outro.");
		}
	
		Cliente cliente = new Cliente();
		cliente.setNome(clienteInserirDto.getNome());
		cliente.setCpf(clienteInserirDto.getCpf());
		cliente.setTelefone(clienteInserirDto.getTelefone());
		cliente.setUsuario(clienteInserirDto.getUsuario());
		cliente.setEmail(clienteInserirDto.getEmail());
		cliente.setSenha(cripto.encode(clienteInserirDto.getSenha()));
		cliente.setNrendereco(clienteInserirDto.getNrendereco());
		cliente.setComplemento(clienteInserirDto.getComplemento());
		
		EnderecoDTO var = EnderecoService.inserir(clienteInserirDto.getEndereco());
		Endereco endereco = new Endereco(var.getCep(), var.getLogradouro(), var.getBairro(), var.getLocalidade(),var.getUf());
		
		clienteInserirDto.setEndereco(endereco);
		cliente.setEndereco(clienteInserirDto.getEndereco());

		clienteRepository.save(cliente);
		mailConfig.enviarEmail(cliente.getEmail(), "API Rest: Cadastro confirmado!", cliente.toString());
		
		return new ClienteDTO(cliente);
	}
	
	public ClienteDTO atualizarPorId(Long id, ClienteInserirDTO clienteInserirDto) throws IOException {
		if (clienteRepository.existsById(id)) {

			Cliente cliente = new Cliente();
			cliente.setNome(clienteInserirDto.getNome());
			cliente.setCpf(clienteInserirDto.getCpf());
			cliente.setTelefone(clienteInserirDto.getTelefone());
			cliente.setUsuario(clienteInserirDto.getUsuario());
			cliente.setEmail(clienteInserirDto.getEmail());
			cliente.setSenha(cripto.encode(clienteInserirDto.getSenha()));
			cliente.setNrendereco(clienteInserirDto.getNrendereco());
			cliente.setComplemento(clienteInserirDto.getComplemento());
			
			EnderecoDTO var = EnderecoService.inserir(clienteInserirDto.getEndereco());
			Endereco endereco = new Endereco(var.getCep(), var.getLogradouro(), var.getBairro(), var.getLocalidade(),
					var.getUf());
			
			clienteInserirDto.setEndereco(endereco);
			cliente.setEndereco(clienteInserirDto.getEndereco());
			

			clienteRepository.save(cliente);
			mailConfig.enviarEmail(cliente.getEmail(), "API Rest: Alterações na conta!", cliente.toString());
			return new ClienteDTO(cliente);
		}
		return null;
	}
	
	public void deletarPorCpf(String cpf) {
		if (clienteRepository.existsByCpf(cpf) != null) {
			clienteRepository.deleteByCpf(cpf);
		}
	}

	public void deletarPorId(long id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
		}
	}
	
}
