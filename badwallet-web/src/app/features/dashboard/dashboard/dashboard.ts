import { Component, OnInit, inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

import { WalletApi } from '../../../core/services/wallet-api';
import { Balance } from '../../../core/models/balance';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    MatCardModule,
    MatIconModule
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard implements OnInit {

  private walletApi = inject(WalletApi);

  balance: Balance | null = null;

  // À remplacer plus tard par l'utilisateur connecté
  phone = '771234567';

  ngOnInit(): void {
    this.loadBalance();
  }

  loadBalance(): void {
    this.walletApi.getBalance(this.phone).subscribe({
      next: (data) => {
        this.balance = data;
      },
      error: (err) => {
        console.error('Erreur lors du chargement du solde', err);
      }
    });
  }
}