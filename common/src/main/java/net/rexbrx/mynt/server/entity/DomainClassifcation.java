package net.rexbrx.mynt.server.entity;

public class DomainClassifcation implements IDomainClassification {

    private eDomain domain_ref;
    private eKingdom kingdom_ref;
    private eMetazoa metazoa_ref;

    public DomainClassifcation(eDomain domain, eKingdom kingdom, eMetazoa metazoa) {
        this.domain_ref = domain;
        this.kingdom_ref = kingdom;
        this.metazoa_ref = metazoa;
    }

    @Override
    public eDomain getDomain() {
        return domain_ref;
    }

    @Override
    public void setDomain(eDomain domain) {
        this.domain_ref = domain;
    }

    @Override
    public eKingdom getKingdom() {
        return kingdom_ref;
    }

    @Override
    public void setKingdom(eKingdom kingdom) {
        this.kingdom_ref = kingdom;
    }

    @Override
    public eMetazoa getMetazoa() {
        return metazoa_ref;
    }

    @Override
    public void setMetazoa(eMetazoa metazoa) {
        this.metazoa_ref = metazoa;
    }
}
