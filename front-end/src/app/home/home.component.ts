import { Component, OnInit } from '@angular/core';
import { TransfersService } from '../transfers.service';
import { TransfersModel } from './transfers.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  transfer: TransfersModel = new TransfersModel();
  transfers: Array<any> = new Array();

  constructor(private transfersService: TransfersService) { }

  ngOnInit (): void {
    this.listTransfers();  
  }

  register(){
    console.log(this.transfer);
    this.transfersService.registerTransfer(this.transfer).subscribe(transfer => {
      this.transfer = new TransfersModel();
      this.listTransfers();
    }, err => {
      console.log('Erro Ao Cadastrar', err)
    })
  }

  listTransfers () {
    this.transfersService.listTransfers().subscribe(transfers => {
      this.transfers = transfers;
    }, err => {
      console.log('ERRO');
    })
  }

}
