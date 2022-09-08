package com.github.allanccruz.service.impl;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.entities.ItemPedido;
import com.github.allanccruz.domain.entities.Pedido;
import com.github.allanccruz.domain.entities.Produto;
import com.github.allanccruz.domain.repository.ClientesRepository;
import com.github.allanccruz.domain.repository.ItensPedidoRepository;
import com.github.allanccruz.domain.repository.PedidosRepository;
import com.github.allanccruz.domain.repository.ProdutosRepository;
import com.github.allanccruz.exceptions.RegraDeNegocioException;
import com.github.allanccruz.rest.dto.ItemPedidoDTO;
import com.github.allanccruz.rest.dto.PedidoDTO;
import com.github.allanccruz.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidosRepository pedidosRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;
    private final ItensPedidoRepository itensPedidoRepository;

    @Override
    @Transactional
    public Pedido save(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraDeNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido = converterItens(pedido, dto.getItens());
        pedidosRepository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraDeNegocioException("Não é possível realizar um pedido sem itens.");
        }

        return itens
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraDeNegocioException(
                                            "Código de produto inválido: "+ idProduto
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());

    }
}
