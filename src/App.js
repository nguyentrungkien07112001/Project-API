import './App.css';
import Navbar from './components/Navbar';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './components/pages/Home';
import About from './components/pages/About';
import SignUp from './components/pages/SignUp';
import Contact from './components/pages/Contact';
import Target1 from './components/pages/targets/Target1';

function App() {
  return (
    <>
    <Router>
      <Navbar/>
      <Switch>
        <Route path='/' exact  component={Home} />
        <Route path='/contact' component={Contact} />
        <Route path='/about' component={About} />
        <Route path='/sign-up' component={SignUp} />
        
        <Route path='/target-1' component={Target1} />
      </Switch>
    </Router>
    </> 
  );
}

export default App;
