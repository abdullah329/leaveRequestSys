import { Component, OnInit } from '@angular/core';
import { LeaveApplicationModel } from '../model/LeaveApplicationModel';
import { LeaveApplicationService } from '../services/leave-application.service';
import {FormControl} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';
import {ProductService} from '../../../shared/services/product.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-leave-transaction',
  templateUrl: './leave-request-trace.component.html',
  styleUrls: ['./leave-request-trace.component.scss']
})
export class LeaveRequestTraceComponent implements OnInit {

  searchControl: FormControl = new FormControl();
  products;
  filteredProducts;

  constructor(
      private productService: ProductService,

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



}
