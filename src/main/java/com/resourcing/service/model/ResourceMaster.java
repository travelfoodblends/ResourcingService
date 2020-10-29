package com.resourcing.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resourcemaster")
public class ResourceMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rgs_id")
	private int id;
	
	/** The requirement id. */
	@Column(name = "rgs_requirement_id")
	private String requirementId;
	
	/** The requirement create date. */
	@Column(name = "rgs_create_date")
	private Date requirementCreateDate;

	/** The request status. */
	@Column(name = "rgs_request_status")
	private String requestStatus;
	
	/** The account name. */
	@Column(name = "rgs_account_name")
	private String accountName;
	
	/** The sub unit name. */
	@Column(name = "rgs_subunit_name")
	private String subUnitName;
	
	/** The requirement lead name. */
	@Column(name = "rgs_req_lead_name")
	private String requirementLeadName;
	
	/** The requirement type. */
	@Column(name = "rgs_req_type")
	private String requirementType;
	
	/** The position type. */
	@Column(name = "rgs_position_type")
	private String positionType;
	
	/** The location. */
	@Column(name = "rgs_location")
	private String location;
	
	/** The work location city. */
	@Column(name = "rgs_work_location_city")
	private String workLocationCity;
	
	/** The work location state. */
	@Column(name = "rgs_work_location_state")
	private String workLocationState;
	
	/** The work location country. */
	@Column(name = "rgs_work_location_country")
	private String workLocationCountry;
	
	/** The tentative tcs grade. */
	@Column(name = "rgs_tentative_tcs_grade")
	private String tentativeTcsGrade;

	/** The position count. */
	@Column(name = "rgs_position_count")
	private String positionCount;
	
	/** The onboarding date. */
	@Column(name = "rgs_onboard_date")
	private Date onboardingDate;
	
	/** The job role. */
	@Column(name = "rgs_job_role")
	private String jobRole;
	
	/** The job key skill. */
	@Column(name = "rgs_job_key_Skill")
	private String jobKeySkill;
	
	/** The job primary skill. */
	@Column(name = "rgs_job_primary_Skill")
	private String jobPrimarySkill;
	
	/** The job secondary skill. */
	@Column(name = "rgs_job_secondary_Skill")
	private String jobSecondarySkill;
	
	/** The job description. */
	@Column(name = "rgs_job_desription")
	private String jobDescription;
	
	/** The experience reqd. */
	@Column(name = "rgs_exp_reqd")
	private String experienceReqd;
	
	/** The sow type. */
	@Column(name = "rgs_sow_type")
	private String sowType;
	
	/** The crm id. */
	@Column(name = "rgs_crm_id")
	private String crmId;
	
	/** The billing start date. */
	@Column(name = "rgs_billing_strt_date")
	private Date billingStartDate;

	/** The billing rate category. */
	@Column(name = "rgs_billing_rate_Category")
	private String billingRateCategory;
	
	/** The billing rate. */
	@Column(name = "rgs_billing_rate")
	private float billingRate;
	
	/** The beeline id. */
	@Column(name = "rgs_beeline_id")
	private String beelineId;
	
	/** The replacement emp id. */
	@Column(name = "rgs_replacement_empid")
	private String replacementEmpId;
	
	/** The client interview reqd. */
	@Column(name = "rgs_client_intrview_reqd")
	private Boolean clientInterviewReqd;
	
	/** The pref resource type. */
	@Column(name = "rgs_pref_resource_type")
	private String prefResourceType;
	
	/** The evaluator emp id. */
	@Column(name = "rgs_eval_empid")
	private String evaluatorEmpId;
	
	/** The evaluator name. */
	@Column(name = "rgs_eval_name")
	private String evaluatorName;
	
	/** The evaluator contact. */
	@Column(name = "rgs_eval_contact")
	private String evaluatorContact;

	/**
	 * Gets the requirement id.
	 *
	 * @return the requirement id
	 */
	public String getRequirementId() {
		return requirementId;
	}

	/**
	 * Sets the requirement id.
	 *
	 * @param requirementId the new requirement id
	 */
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	/**
	 * Gets the requirement create date.
	 *
	 * @return the requirement create date
	 */
	public Date getRequirementCreateDate() {
		return requirementCreateDate;
	}

	/**
	 * Sets the requirement create date.
	 *
	 * @param requirementCreateDate the new requirement create date
	 */
	public void setRequirementCreateDate(Date requirementCreateDate) {
		this.requirementCreateDate = requirementCreateDate;
	}

	/**
	 * Gets the request status.
	 *
	 * @return the request status
	 */
	public String getRequestStatus() {
		return requestStatus;
	}

	/**
	 * Sets the request status.
	 *
	 * @param requestStatus the new request status
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	/**
	 * Gets the account name.
	 *
	 * @return the account name
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Sets the account name.
	 *
	 * @param accountName the new account name
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Gets the sub unit name.
	 *
	 * @return the sub unit name
	 */
	public String getSubUnitName() {
		return subUnitName;
	}

	/**
	 * Sets the sub unit name.
	 *
	 * @param subUnitName the new sub unit name
	 */
	public void setSubUnitName(String subUnitName) {
		this.subUnitName = subUnitName;
	}

	/**
	 * Gets the requirement lead name.
	 *
	 * @return the requirement lead name
	 */
	public String getRequirementLeadName() {
		return requirementLeadName;
	}

	/**
	 * Sets the requirement lead name.
	 *
	 * @param requirementLeadName the new requirement lead name
	 */
	public void setRequirementLeadName(String requirementLeadName) {
		this.requirementLeadName = requirementLeadName;
	}

	/**
	 * Gets the requirement type.
	 *
	 * @return the requirement type
	 */
	public String getRequirementType() {
		return requirementType;
	}

	/**
	 * Sets the requirement type.
	 *
	 * @param requirementType the new requirement type
	 */
	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	/**
	 * Gets the position type.
	 *
	 * @return the position type
	 */
	public String getPositionType() {
		return positionType;
	}

	/**
	 * Sets the position type.
	 *
	 * @param positionType the new position type
	 */
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the work location city.
	 *
	 * @return the work location city
	 */
	public String getWorkLocationCity() {
		return workLocationCity;
	}

	/**
	 * Sets the work location city.
	 *
	 * @param workLocationCity the new work location city
	 */
	public void setWorkLocationCity(String workLocationCity) {
		this.workLocationCity = workLocationCity;
	}

	/**
	 * Gets the work location state.
	 *
	 * @return the work location state
	 */
	public String getWorkLocationState() {
		return workLocationState;
	}

	/**
	 * Sets the work location state.
	 *
	 * @param workLocationState the new work location state
	 */
	public void setWorkLocationState(String workLocationState) {
		this.workLocationState = workLocationState;
	}

	/**
	 * Gets the work location country.
	 *
	 * @return the work location country
	 */
	public String getWorkLocationCountry() {
		return workLocationCountry;
	}

	/**
	 * Sets the work location country.
	 *
	 * @param workLocationCountry the new work location country
	 */
	public void setWorkLocationCountry(String workLocationCountry) {
		this.workLocationCountry = workLocationCountry;
	}

	/**
	 * Gets the tentative tcs grade.
	 *
	 * @return the tentative tcs grade
	 */
	public String getTentativeTcsGrade() {
		return tentativeTcsGrade;
	}

	/**
	 * Sets the tentative tcs grade.
	 *
	 * @param tentativeTcsGrade the new tentative tcs grade
	 */
	public void setTentativeTcsGrade(String tentativeTcsGrade) {
		this.tentativeTcsGrade = tentativeTcsGrade;
	}

	/**
	 * Gets the position count.
	 *
	 * @return the position count
	 */
	public String getPositionCount() {
		return positionCount;
	}

	/**
	 * Sets the position count.
	 *
	 * @param positionCount the new position count
	 */
	public void setPositionCount(String positionCount) {
		this.positionCount = positionCount;
	}

	/**
	 * Gets the onboarding date.
	 *
	 * @return the onboarding date
	 */
	public Date getOnboardingDate() {
		return onboardingDate;
	}

	/**
	 * Sets the onboarding date.
	 *
	 * @param onboardingDate the new onboarding date
	 */
	public void setOnboardingDate(Date onboardingDate) {
		this.onboardingDate = onboardingDate;
	}

	/**
	 * Gets the job role.
	 *
	 * @return the job role
	 */
	public String getJobRole() {
		return jobRole;
	}

	/**
	 * Sets the job role.
	 *
	 * @param jobRole the new job role
	 */
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	/**
	 * Gets the job key skill.
	 *
	 * @return the job key skill
	 */
	public String getJobKeySkill() {
		return jobKeySkill;
	}

	/**
	 * Sets the job key skill.
	 *
	 * @param jobKeySkill the new job key skill
	 */
	public void setJobKeySkill(String jobKeySkill) {
		this.jobKeySkill = jobKeySkill;
	}

	/**
	 * Gets the job primary skill.
	 *
	 * @return the job primary skill
	 */
	public String getJobPrimarySkill() {
		return jobPrimarySkill;
	}

	/**
	 * Sets the job primary skill.
	 *
	 * @param jobPrimarySkill the new job primary skill
	 */
	public void setJobPrimarySkill(String jobPrimarySkill) {
		this.jobPrimarySkill = jobPrimarySkill;
	}

	/**
	 * Gets the job secondary skill.
	 *
	 * @return the job secondary skill
	 */
	public String getJobSecondarySkill() {
		return jobSecondarySkill;
	}

	/**
	 * Sets the job secondary skill.
	 *
	 * @param jobSecondarySkill the new job secondary skill
	 */
	public void setJobSecondarySkill(String jobSecondarySkill) {
		this.jobSecondarySkill = jobSecondarySkill;
	}

	/**
	 * Gets the job description.
	 *
	 * @return the job description
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * Sets the job description.
	 *
	 * @param jobDescription the new job description
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * Gets the experience reqd.
	 *
	 * @return the experience reqd
	 */
	public String getExperienceReqd() {
		return experienceReqd;
	}

	/**
	 * Sets the experience reqd.
	 *
	 * @param experienceReqd the new experience reqd
	 */
	public void setExperienceReqd(String experienceReqd) {
		this.experienceReqd = experienceReqd;
	}

	/**
	 * Gets the sow type.
	 *
	 * @return the sow type
	 */
	public String getSowType() {
		return sowType;
	}

	/**
	 * Sets the sow type.
	 *
	 * @param sowType the new sow type
	 */
	public void setSowType(String sowType) {
		this.sowType = sowType;
	}

	/**
	 * Gets the crm id.
	 *
	 * @return the crm id
	 */
	public String getCrmId() {
		return crmId;
	}

	/**
	 * Sets the crm id.
	 *
	 * @param crmId the new crm id
	 */
	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	/**
	 * Gets the billing start date.
	 *
	 * @return the billing start date
	 */
	public Date getBillingStartDate() {
		return billingStartDate;
	}

	/**
	 * Sets the billing start date.
	 *
	 * @param billingStartDate the new billing start date
	 */
	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	/**
	 * Gets the billing rate.
	 *
	 * @return the billing rate
	 */
	public float getBillingRate() {
		return billingRate;
	}

	/**
	 * Sets the billing rate.
	 *
	 * @param billingRate the new billing rate
	 */
	public void setBillingRate(float billingRate) {
		this.billingRate = billingRate;
	}

	/**
	 * Gets the beeline id.
	 *
	 * @return the beeline id
	 */
	public String getBeelineId() {
		return beelineId;
	}

	/**
	 * Sets the beeline id.
	 *
	 * @param beelineId the new beeline id
	 */
	public void setBeelineId(String beelineId) {
		this.beelineId = beelineId;
	}

	/**
	 * Gets the replacement emp id.
	 *
	 * @return the replacement emp id
	 */
	public String getReplacementEmpId() {
		return replacementEmpId;
	}

	/**
	 * Sets the replacement emp id.
	 *
	 * @param replacementEmpId the new replacement emp id
	 */
	public void setReplacementEmpId(String replacementEmpId) {
		this.replacementEmpId = replacementEmpId;
	}

	/**
	 * Gets the client interview reqd.
	 *
	 * @return the client interview reqd
	 */
	public Boolean getClientInterviewReqd() {
		return clientInterviewReqd;
	}

	/**
	 * Sets the client interview reqd.
	 *
	 * @param clientInterviewReqd the new client interview reqd
	 */
	public void setClientInterviewReqd(Boolean clientInterviewReqd) {
		this.clientInterviewReqd = clientInterviewReqd;
	}

	/**
	 * Gets the pref resource type.
	 *
	 * @return the pref resource type
	 */
	public String getPrefResourceType() {
		return prefResourceType;
	}

	/**
	 * Sets the pref resource type.
	 *
	 * @param prefResourceType the new pref resource type
	 */
	public void setPrefResourceType(String prefResourceType) {
		this.prefResourceType = prefResourceType;
	}

	/**
	 * Gets the evaluator emp id.
	 *
	 * @return the evaluator emp id
	 */
	public String getEvaluatorEmpId() {
		return evaluatorEmpId;
	}

	/**
	 * Sets the evaluator emp id.
	 *
	 * @param evaluatorEmpId the new evaluator emp id
	 */
	public void setEvaluatorEmpId(String evaluatorEmpId) {
		this.evaluatorEmpId = evaluatorEmpId;
	}

	/**
	 * Gets the evaluator name.
	 *
	 * @return the evaluator name
	 */
	public String getEvaluatorName() {
		return evaluatorName;
	}

	/**
	 * Sets the evaluator name.
	 *
	 * @param evaluatorName the new evaluator name
	 */
	public void setEvaluatorName(String evaluatorName) {
		this.evaluatorName = evaluatorName;
	}

	/**
	 * Gets the evaluator contact.
	 *
	 * @return the evaluator contact
	 */
	public String getEvaluatorContact() {
		return evaluatorContact;
	}

	/**
	 * Sets the evaludator contact.
	 *
	 * @param evaludatorContact the new evaludator contact
	 */
	public void setEvaluatorContact(String evaluatorContact) {
		this.evaluatorContact = evaluatorContact;
	}

	/**
	 * @return the billingRateCategory
	 */
	public String getBillingRateCategory() {
		return billingRateCategory;
	}

	/**
	 * @param billingRateCategory the billingRateCategory to set
	 */
	public void setBillingRateCategory(String billingRateCategory) {
		this.billingRateCategory = billingRateCategory;
	}

}
