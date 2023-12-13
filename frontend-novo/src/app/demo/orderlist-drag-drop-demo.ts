import { Component, OnInit } from '@angular/core';
import { Product } from '../../domain/product';
import { ProductService } from '../../service/productservice';

@Component({
    selector: 'orderlist-drag-drop-demo',
    templateUrl: './orderlist-drag-drop-demo.html'
})
export class OrderlistDragDropDemo implements OnInit {
    products: Product[];

    constructor(private productService: ProductService) {}

    ngOnInit() {
      this.products = [
        { id: '1', name: 'Product 1', category: 'Category 1', price: 10.99, image: 'product1.jpg', position: 1 },
        { id: '2', name: 'Product 2', category: 'Category 2', price: 20.99, image: 'product2.jpg', position: 2 },
      ]
    }

    getSeverity(status: string) {
        switch (status) {
            case 'INSTOCK':
                return 'success';
            case 'LOWSTOCK':
                return 'warning';
            case 'OUTOFSTOCK':
                return 'danger';
        }
    }

  onProductReorder(event: any) {
    // Atualize a posição de cada produto após a reordenação
    this.products.forEach((product, index) => {
      product.position = index + 1;
    });

    // Agora, você pode salvar a nova ordem e as posições no banco de dados
    console.log('Lista de produtos reordenada:', this.products);
    // Faça uma chamada para o serviço backend para atualizar os índices e posições no banco de dados.
  }
}
