package br.com.cadastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.domain.Produto;
import br.com.cadastro.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin("*")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/id")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto produto = service.findById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = service.findAll();
		return ResponseEntity.ok().body(produtos );
	}
}
	