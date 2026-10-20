package net.rexbrx.mynt.server.entity;

public interface IDomainClassification {
    enum eDomain {NULL, BACTERIA, ARCHAEA, EUKARYA}
    eDomain getDomain();
    void setDomain(eDomain domain);

    // only animalia will be used :D
    enum eKingdom {NULL, ANIMALIA, FUNGI, PLANTAE}
    eKingdom getKingdom();
    void setKingdom(eKingdom kingdom);

    // only porifera will be unused because itll be statics
    enum eMetazoa {NULL, ARTHROPODA, CHORDATA, CNIDARIA, PORIFERA}
    eMetazoa getMetazoa();
    void setMetazoa(eMetazoa metazoa);
}
