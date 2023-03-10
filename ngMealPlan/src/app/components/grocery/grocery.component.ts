import { CommonService } from './../../services/common.service';
import { AuthService } from 'src/app/services/auth.service';
import { GroceryService } from './../../services/grocery.service';
import { Component } from '@angular/core';
import { Grocery } from 'src/app/models/grocery';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-grocery',
  templateUrl: './grocery.component.html',
  styleUrls: ['./grocery.component.css'],
})
export class GroceryComponent {
  groceries: Grocery[] | null = null;
  messageReceived: any;
  subscriptionName: Subscription | null = null;

  constructor(
    private groceryServ: GroceryService,
    private auth: AuthService,
    private commonService: CommonService
  ) {}

  ngOnInit() {
    if (this.auth.checkLogin()) {
      this.index();
    }

    this.subscriptionName = this.commonService
      .getUpdate()
      .subscribe((message) => {
        //message contains the data sent from service
        if ( message === 'refresh') {
          this.index();
        }
      });
  }

  index() {
    this.groceryServ.index().subscribe({
      next: (groceries: Grocery[]) => {
        this.groceries = groceries;
      },
      error: (err: any) => {
        console.error(err);
      },
    });
  }

  create(grocery: Grocery) {
    this.groceryServ.create(grocery).subscribe({
      next: (grocery: Grocery) => {
        this.index();
      },
      error: (err: any) => {
        console.error(err);
      },
    });
  }

  update(grocery: Grocery) {
    this.groceryServ.update(grocery).subscribe({
      next: (grocery: Grocery) => {
        this.index();
      },
      error: (err: any) => {
        console.error(err);
      },
    });
  }
}
