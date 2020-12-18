import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  product: Product = { name: "", price: 0.0 }

  constructor(private router: Router, private service: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.service.readById(`${id}`).subscribe(product => {
      this.product = product;
    })
  }

  deleteProduto(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.service.delete(`${id}`).subscribe(() => {
      this.service.showMessage("Produto deletado!");
      this.router.navigate(["products"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/products"]);
  }
}
