import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import Header from './components/Header';
import ParkDetailPage from './pages/ParkDetailPage';

export default function App() {
  return (
    <>
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/parkDetail" element={<ParkDetailPage />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}