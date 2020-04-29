import { Component, OnInit } from '@angular/core';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';
import { LeaveApplicationService } from '../services/leave-application.service';
import {FormControl} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';
import {ProductService} from '../../../shared/services/product.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-leave-transaction',
  templateUrl: './leave-transaction.component.html',
  styleUrls: ['./leave-transaction.component.scss']
})
export class LeaveTransactionComponent implements OnInit {

  searchControl: FormControl = new FormControl();
  products;
  filteredProducts;

  constructor(
      private productService: ProductService,
      private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.productService.getProducts()
        .subscribe((res: any[]) => {
          this.products = [...res];
          this.filteredProducts = res;
        });
    this.searchControl.valueChanges
        .pipe(debounceTime(200))
        .subscribe(value => {
          this.filerData(value);
        });
  }

  filerData(val) {
    if (val) {
      val = val.toLowerCase();
    } else {
      return this.filteredProducts = [...this.products];
    }

    const columns = Object.keys(this.products[0]);
    if (!columns.length) {
      return;
    }

    const rows = this.products.filter(function(d) {
      for (let i = 0; i <= columns.length; i++) {
        const column = columns[i];
        // console.log(d[column]);
        if (d[column] && d[column].toString().toLowerCase().indexOf(val) > -1) {
          return true;
        }
      }
    });
    this.filteredProducts = rows;
  }
  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' })
        .result.then((result) => {
      console.log(result);
    }, (reason) => {
      console.log('Err!', reason);
    });
  }
}
