package br.org.serratec.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.api.dto.EnderecoDTO;
import br.org.serratec.api.dto.EnderecoInserirDTO;
import br.org.serratec.api.model.Endereco;
import br.org.serratec.api.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<EnderecoDTO> listar() {

		List<EnderecoDTO> enderecosDTO = new ArrayList<EnderecoDTO>();
		List<Endereco> enderecos = enderecoRepository.findAll();

		for (Endereco endereco : enderecos) {
			EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
			enderecosDTO.add(enderecoDTO);
		}
		return enderecosDTO;
	}

	public Optional<EnderecoDTO> buscarPorId(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		Optional<EnderecoDTO> enderecoDto = Optional.ofNullable(new EnderecoDTO(endereco.get()));
		
		if (endereco.isPresent()) {
			return enderecoDto;
		}
		return null;
	}
	
	public EnderecoDTO buscarPorCep(String cep) {
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if (endereco.isPresent()) {
			return new EnderecoDTO(endereco.get());
		} else {
			EnderecoInserirDTO enderecoInserirDTO = new EnderecoInserirDTO();
			enderecoInserirDTO.setCep(cep);
			return inserir(enderecoInserirDTO);
		}
	}


	public EnderecoDTO inserir(EnderecoInserirDTO enderecoDTO) {
		System.out.println(enderecoDTO.getCep());
		System.out.println("endereco da tabela1   "+enderecoRepository.findByCep(enderecoDTO.getCep()));
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(enderecoDTO.getCep()));
		System.out.println("endereco da tabela2   ");
		if (endereco.isPresent()) {
			System.out.println("endereco da tabela3   "+endereco.get());
			return new EnderecoDTO(endereco.get());
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uriViaCep = "https://viacep.com.br/ws/" + enderecoDTO.getCep() + "/json/";
			Optional<Endereco> enderecoViaCep = Optional
					.ofNullable(restTemplate.getForObject(uriViaCep, Endereco.class));
			System.out.println("endereco da tabela4   "+enderecoViaCep.get());
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);

				Endereco var = enderecoViaCep.get();
				EnderecoDTO enderecoDto = new EnderecoDTO(var);
				System.out.println("endereco da tabela5   "+enderecoDto.getCep());
				//enderecoRepository.save(var);
				return enderecoDto;
			} else {
				return null;
			}
		}

	}
	
	/*public EnderecoDTO inserirDeFato(EnderecoInserirDTO enderec) {

		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(enderec.getCep()));
		if (endereco.isPresent()) {
			return new EnderecoDTO(endereco.get());
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uriViaCep = "https://viacep.com.br/ws/" + enderec.getCep() + "/json/";
			Optional<Endereco> enderecoViaCep = Optional
					.ofNullable(restTemplate.getForObject(uriViaCep, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);

				Endereco var = enderecoViaCep.get();
				enderecoRepository.save(var);
				return new EnderecoDTO(var);
			} else {
				return null;
			}
		}

	}*/

	public void deletarPorId(Long id) {
		if (enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
		}
	}

}
