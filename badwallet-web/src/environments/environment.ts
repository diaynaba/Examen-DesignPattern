export interface Wallet {
  id: number;
  firstName: string;
  lastName: string;
  phone: string;
  balance: number;
  createdAt: string;
}
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};