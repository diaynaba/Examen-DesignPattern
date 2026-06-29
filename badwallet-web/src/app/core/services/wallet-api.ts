import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../../environments/environment';

import { Wallet } from '../models/wallet';
import { Balance } from '../models/balance';
import { Transfer } from '../models/transfer';
import { Deposit } from '../models/deposit';
import { Withdraw } from '../models/withdraw';
import { Transaction } from '../models/transaction';

@Injectable({
  providedIn: 'root'
})
export class WalletApi {

  private http = inject(HttpClient);

  private api = `${environment.apiUrl}/wallets`;

  getWallets(page = 0, size = 10): Observable<any> {
    return this.http.get<any>(`${this.api}?page=${page}&size=${size}`);
  }

  getWallet(phone: string): Observable<Wallet> {
    return this.http.get<Wallet>(`${this.api}/${phone}`);
  }

  getBalance(phone: string): Observable<Balance> {
    return this.http.get<Balance>(`${this.api}/${phone}/balance`);
  }

  createWallet(wallet: any): Observable<Wallet> {
    return this.http.post<Wallet>(this.api, wallet);
  }

  deposit(walletId: number, body: Deposit): Observable<any> {
    return this.http.post(`${this.api}/${walletId}/deposit`, body);
  }

  withdraw(body: Withdraw): Observable<any> {
    return this.http.post(`${this.api}/withdraw`, body);
  }

  transfer(body: Transfer): Observable<any> {
    return this.http.post(`${this.api}/transfer`, body);
  }

  getHistory(phone: string): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.api}/${phone}/history`);
  }

}