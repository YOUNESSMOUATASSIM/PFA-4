import Breadcrumb from 'react-bootstrap/Breadcrumb'

function BreadCrumb({crumbs}){
  return (
    <Breadcrumb>
      {crumbs.map((item, idx) => (idx != crumbs.length?<Breadcrumb.Item href="#">{item}</Breadcrumb.Item>:<Breadcrumb.Item active>{item}</Breadcrumb.Item>))}
    </Breadcrumb>
  )
}

export default BreadCrumb