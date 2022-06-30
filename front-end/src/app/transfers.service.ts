import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { TransfersModel } from './home/transfers.model';


@Injectable({
  providedIn: 'root'
})
export class TransfersService {

  constructor(private http: HttpClient) { }

  registerTransfer(transfer : TransfersModel) : Observable<any>{
   return this.http.post("http://localhost:8080/api/v1/userFinancialTransfer/create", transfer)
  }

  listTransfers() : Observable<any>{
    return this.http.get("http://localhost:8080/api/v1/userFinancialTransfer/get");
  }
}
