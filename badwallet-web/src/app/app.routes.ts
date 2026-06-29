import { Routes } from '@angular/router';

import { ClientLayout } from './layouts/client-layout/client-layout';
import { AdminLayout } from './layouts/admin-layout/admin-layout';

import { Dashboard } from './features/dashboard/dashboard/dashboard';
import { Transfer } from './features/transfer/transfer/transfer';
import { Transactions } from './features/transactions/transactions/transactions';
import { CurrentBills } from './features/billing/current-bills/current-bills';
import { HistoryBills } from './features/billing/history-bills/history-bills';

import { WalletList } from './features/admin/wallet-list/wallet-list';
import { CreateWallet } from './features/admin/create-wallet/create-wallet';
import { SearchWallet } from './features/admin/search-wallet/search-wallet';
import { Deposit } from './features/admin/deposit/deposit';
import { Withdraw } from './features/admin/withdraw/withdraw';

export const routes: Routes = [

  {
    path: '',
    component: ClientLayout,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: Dashboard },
      { path: 'transfer', component: Transfer },
      { path: 'transactions', component: Transactions },
      { path: 'bills/current', component: CurrentBills },
      { path: 'bills/history', component: HistoryBills }
    ]
  },

  {
    path: 'admin',
    component: AdminLayout,
    children: [
      { path: 'wallets', component: WalletList },
      { path: 'create-wallet', component: CreateWallet },
      { path: 'search', component: SearchWallet },
      { path: 'deposit', component: Deposit },
      { path: 'withdraw', component: Withdraw }
    ]
  }

];