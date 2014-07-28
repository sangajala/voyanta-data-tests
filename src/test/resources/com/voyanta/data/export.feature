@export
Feature: Checking the export functionality

  Scenario Outline: Export functionality
    
    Given all the files are saved under 'StandartExport' folder
    Given an exported file exists with name '<ExpectedFile>'
    And data is loaded with entity name '<Entity>' with primary key '<primarykey>' 
    And ignore the validation taking today's value for <NodeList>
    Then both files should have same set of data

  Examples:

    | ExpectedFile                                 | Entity              | primarykey              | | 
    | BUILDING-Asset.xml                           | BUILDING            | AssetReference          || 
    | LEASE-Lease.xml                              | LEASE               | LeaseReference          || 
    | DEVELOPMENT-Development.xml                  | DEVELOPMENT         | AssetReference          || 
    | LEGALENTITY-Legal Entity.xml                 | LEGALENTITY         | LegalEntityReference    |
    | LEGALENTITYVENDOR-Legal Entity Vendor.xml    | LEGALENTITYVENDOR   | LegalEntityReference    |
    | ASSETTRANSACTION-Asset Transaction.xml       | ASSETTRANSACTION    | AssetReference          |
    | INVESTMENTLIMIT-Investment Limit.xml         | INVESTMENTLIMIT     | InvestmentReference     |
    | INVESTMENTVALUATION-Investment Valuation.xml | INVESTMENTVALUATION | InvestmentReference     |
    | DEBTFACILITY-Debt Facility.xml               | DEBTFACILITY        | DebtFacilityReference   |
    | DEBTFACILITYEVENT-Debt Facility Event.xml    | DEBTFACILITYEVENT   | DebtFacilityReference   |
    | DEBTFACILITYSTATUS-Debt Facility Status.xml  | DEBTFACILITYSTATUS  | DebtFacilityReference   |
    | FARM-Farm.xml                                | FARM                | AssetReference          |
    | LEGALENTITY-Legal Entity.xml                 | LEGALENTITY         | LegalEntityReference    |
    | LEGALENTITYVENDOR-Legal Entity Vendor.xml    | LEGALENTITYVENDOR   | LegalEntityReference    |
    | INVESTMENT-Investment.xml                    | INVESTMENT          | LegalEntityReference    |
    | ACCOUNT-Account.xml                          | ACCOUNT             | AccountNumber           |
    | DEBTFACILITY-Debt Facility.xml               | DEBTFACILITY        | DebtFacilityReference   |
    | ASSETVALUATION-Asset Valuation.xml           | ASSETVALUATION      | AssetReference          |
    | GROUNDLEASE-Ground Lease.xml                 | GROUNDLEASE         | GroundLeaseReference    |
    | UNIT-Unit.xml                                | UNIT                | BuildingReference       |
    | LEASE-Lease.xml                              | LEASE               | BuildingReference       |
    | ACCOUNTSRECEIVABLE-Accounts Receivable.xml   | ACCOUNTSRECEIVABLE  | LeaseReference          |
    | UNITVACANCYCOSTS-Unit Vacancy Cost.xml       | UNITVACANCYCOSTS    | AssetReference          |
    | LEASEUNIT-Lease Unit.xml                     | LEASEUNIT           | AssetReference          |
    | RECURRINGBILLING-Recurring Billing.xml       | RECURRINGBILLING    | AssetReference          |
    | RENTESCALATION-Rent Escalation.xml           | RENTESCALATION      | LeaseUnitReference|
    | OPTION-Option.xml                            | OPTION              | LeaseUnitReference      |
    | TENANTALLOWANCE-Tenant Allowance.xml         | TENANTALLOWANCE     | LeaseUnitReference      |
    | RECOVERY-Recovery.xml                        | RECOVERY            | LeaseUnitReference      |
    | SALES-Sales.xml                              | SALES               | LeaseUnitReference      |
    | ASSETTRANSACTION-Asset Transaction.xml       | ASSETTRANSACTION    | AssetReference          |
    | INVESTMENTLIMIT-Investment Limit.xml         | INVESTMENTLIMIT     | InvestmentReference     |
    | INVESTMENTVALUATION-Investment Valuation.xml | INVESTMENTVALUATION | InvestmentReference     |
    | DEBTFACILITYEVENT-Debt Facility Event.xml    | DEBTFACILITYEVENT   | DebtFacilityReference   |
    | DEBTFACILITYSTATUS-Debt Facility Status.xml  | DEBTFACILITYSTATUS  | DebtFacilityReference   |
    | COVENANT-Covenant.xml                        | COVENANT            | DebtFacilityReference   |
    | COVENANTVALUE-Covenant Value.xml             | COVENANTVALUE       | DebtFacilityReference   |
    | COVENANTLIMIT-Covenant Limit.xml             | COVENANTLIMIT       | DebtFacilityReference   |
    | DEBTCOLLATERAL-Debt Collateral.xml           | DEBTCOLLATERAL      | DebtFacilityReference   |
    | DEBTVALUATION-Debt Valuation.xml             | DEBTVALUATION       | DebtFacilityReference   |
    | EQUITYPARTICIPATION-Equity Participation.xml | EQUITYPARTICIPATION | InvestorReference       |
    | DEBTPARTICIPATION-Debt Participation.xml         | DEBTPARTICIPATION   | DebtFacilityReference   |
    | ACCOUNTACTIVITY-Account Activity.xml             | ACCOUNTACTIVITY     | TransactionReference    |
    | MARKETSTATISTICS-Market Statistics.xml          | MARKETSTATISTICS    | AsOfDate                |
    | ASSUMPTION-Assumption.xml                    | ASSUMPTION          | TopLevelObjectReference |
    | ASSUMPTIONPROFILE-Assumption Profile.xml     | ASSUMPTIONPROFILE   | TopLevelObjectReference |


@Taliance
  Scenario Outline: Taliance Export Test
    
    Given all the files are saved under 'TalianceExport' folder
    Given an exported file exists with name '<ExpectedFile>'
    And data is loaded with entity name '<Entity>' with primary key '<primarykey>'
    Then both files should have same set of data

  Examples:

    | ExpectedFile                                | Entity              | primarykey              |
    | _ACCOUNTING_-Account Activity.xml           | ACCOUNTING          |    IDENTITY       |






